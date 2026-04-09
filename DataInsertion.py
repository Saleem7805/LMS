import pandas as pd
from pymongo import MongoClient

# ==============================
# CONFIGURATION
# ==============================
MONGO_URI = "mongodb://localhost:27017/"
DB_NAME = "LMS"
COLLECTION_NAME = "Student"

FILE_PATH = r"C:/LMS/Student_Info.xlsx"
UNIQUE_KEY = "pibid"   # change if needed

# ==============================
# MAIN FUNCTION
# ==============================
def load_excel_to_mongo():
    try:
        print("Reading Excel file...")

        # Read Excel
        df = pd.read_excel(FILE_PATH)

        # Clean column names
        df.columns = df.columns.str.strip().str.lower()

        print("Columns:", df.columns.tolist())

        # Replace NaN with None (Mongo-friendly)
        df = df.where(pd.notnull(df), None)

        # Convert dataframe to list of dicts
        records = df.to_dict(orient="records")

        # Convert timestamps
        for record in records:
            for key, value in record.items():
                if isinstance(value, pd.Timestamp):
                    record[key] = value.strftime("%Y-%m-%d")

        # Mongo connection
        client = MongoClient(MONGO_URI)
        db = client[DB_NAME]
        collection = db[COLLECTION_NAME]

        print(f"Inserting {len(records)} records...")

        # ==============================
        # OPTION 1: SIMPLE INSERT (NO DUP CHECK)
        # ==============================
        # collection.insert_many(records)

        # ==============================
        # OPTION 2: UPSERT (SAFE, RECOMMENDED)
        # ==============================
        for record in records:
            if UNIQUE_KEY not in record or not record[UNIQUE_KEY]:
                print("Skipping (missing key):", record)
                continue
            record["_id"] = record["pibid"]   # 🔥 CRITICAL FIX
            
            collection.update_one(
                {"_id": record["_id"]},
                {"$set": record},
                upsert=True)

        print("✅ Data successfully loaded into MongoDB!")

    except Exception as e:
        print("Error:", e)


# ==============================
# RUN
# ==============================
if __name__ == "__main__":
    load_excel_to_mongo()