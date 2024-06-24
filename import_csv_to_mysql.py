import pandas as pd
import mysql.connector

# Load the CSV file using pandas
df = pd.read_csv('movies.csv')

# Filter out the columns you want to import
filtered_df = df[['Title', 'Poster', 'Release Year', 'Length in Min', 'IMDB Rating', 'Genres']]

# Replace NaN values with appropriate defaults or handle them
filtered_df = filtered_df.fillna({
    'Title': '',
    'Poster': '',
    'Release Year': 0,
    'Length in Min': 0.0,
    'IMDB Rating': 0.0,
    'Genres': ''
})

# Establish a connection to your MySQL database
mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="",
    database="movies_db"
)

cursor = mydb.cursor()

# Insert data into the MySQL table
for index, row in filtered_df.iterrows():
    cursor.execute(
        """
        INSERT INTO movies (title, poster, release_year, length_in_min, imdb_rating, genres)
        VALUES (%s, %s, %s, %s, %s, %s)
        """,
        (row['Title'], row['Poster'], row['Release Year'], row['Length in Min'], row['IMDB Rating'], row['Genres'])
    )

# Commit the transaction
mydb.commit()

# Close the connection
cursor.close()
mydb.close()

print("Data imported successfully")
