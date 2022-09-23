from flask_app.config.mysqlconnection import connectToMySQL

class User:
    def __init__( self , data ):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users";
        results = connectToMySQL('Users_cr').query_db(query)
        
        users = []

        for user in results:
            users.append( cls(user))
        return users

    @classmethod
    def save(cls, data):
        query = "INSERT INTO users (first_name, last_name, email, created_at, updated_at) VALUES ( %(fname)s, %(lname)s, %(email)s, NOW(), NOW() );"
        return connectToMySQL ('Users_cr').query_db(query, data)
    
    @classmethod
    def show_user(cls, id):
        data ={"id": id}
        query = "SELECT * FROM users WHERE id = %(id)s;"
        results = connectToMySQL('Users_cr').query_db(query,data)

        return (cls(results[0]))

    @classmethod
    def delete_user(cls,id):
        data = {"id": id}
        query = "DELETE FROM users WHERE id = %(id)s;"
        results = connectToMySQL('Users_cr').query_db(query,data)
        return results
    
    @classmethod
    def edit_user(cls,data):
        query = "UPDATE users SET first_name = %(fname)s, last_name = %(lname)s, email = %(email)s  WHERE id = %(id)s;"
        results = connectToMySQL('Users_cr').query_db(query,data)
        return results

## html=>(via- url, request.form)=> server/controller=> (via model method/ user.save) -> model=> (via- mysqlconnection.py ) =>Db