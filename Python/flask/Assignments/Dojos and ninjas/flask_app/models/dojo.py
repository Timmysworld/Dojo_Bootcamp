from flask_app.config.mysqlconnection import connectToMySQL

class Dojo:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM dojo";
        results = connectToMySQL('dojos_and_ninjas_schema').query_db(query)

        dojos = []

        for dojo in results:
            dojos.append(cls(dojo))
        return dojos

    @classmethod
    def save(cls, data):
        query = "INSERT INTO dojo (name, created_at, updated_at) VALUE (%(name)s, NOW(), NOW() );"
        return connectToMySQL ('dojos_and_ninjas_schema').query_db(query,data)

    # @classmethod
    # def show_dojo(cls, id):
    #     data = {"id": id}
    #     query = " SELECT * FROM dojo;"
    #     results = connectToMySQL('dojos_and_ninjas_schema').query_db(query,data)

    #     return dojo