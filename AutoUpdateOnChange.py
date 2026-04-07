import pandas as pd
from pymongo import MongoClient
from watchdog.observers import Observer
from watchdog.events import FileSystemEventHandler
import time
import os

# ==============================
# CONFIGURATION
# ==============================
MONGO_URI = "mongodb://localhost:27017/"
DB_NAME = "LMS"
COLLECTION_NAME = "Student"

FILE_PATH = r"C:\LMS\Student Credential.xlsx"

# ==============================
# MONGO CONNECTION
# ==============================
client = MongoClient(MONGO_URI)
db = client[DB_NAME]
collection = db[COLLECTION_NAME]


# ==============================
# SYNC FUNCTION
# ==============================
def sync_excel_to_mongo():
    try:
        print("📖 Reading Excel file...")

        df = pd.read_excel(FILE_PATH)

        # ✅ Clean column names (IMPORTANT FIX)
        df.columns = df.columns.str.strip().str.lower()

        print("🧾 Columns detected:", df.columns.tolist())

        # Convert NaN to None
        df = df.where(pd.notnull(df), None)

        for _, row in df.iterrows():
            data = row.to_dict()

            # ✅ Handle pibid properly
            if "pibid" not in data or not data["pibid"]:
                print("⚠️ Skipping row (missing pibid):", data)
                continue

            # Convert Timestamp to string
            for key, value in data.items():
                if isinstance(value, pd.Timestamp):
                    data[key] = value.strftime("%Y-%m-%d")

            # ✅ Upsert (Insert or Update)
            collection.update_one(
                {"pibid": data["pibid"]},
                {"$set": data},
                upsert=True
            )

        print("✅ MongoDB synced successfully!\n")

    except Exception as e:
        print("❌ Error:", e)


# ==============================
# FILE WATCHER
# ==============================
class ExcelChangeHandler(FileSystemEventHandler):
    def on_modified(self, event):
        if event.src_path.endswith("Student Credential.xlsx"):
            print("📂 Excel file changed. Syncing...")
            time.sleep(2)  # wait for save to complete
            sync_excel_to_mongo()


# ==============================
# MAIN
# ==============================
if __name__ == "__main__":
    print("🚀 Starting Excel → MongoDB Sync...")

    # Initial Load
    sync_excel_to_mongo()

    # Watch for changes
    event_handler = ExcelChangeHandler()
    observer = Observer()
    observer.schedule(event_handler, path=os.path.dirname(FILE_PATH), recursive=False)
    observer.start()

    print("👀 Watching for Excel changes... Press Ctrl+C to stop.\n")

    try:
        while True:
            time.sleep(1)
    except KeyboardInterrupt:
        observer.stop()

    observer.join()