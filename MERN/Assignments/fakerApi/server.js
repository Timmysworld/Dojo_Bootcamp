const express = require('express')
const app = express()
const PORT = 8000

const {faker} = require('@faker-js/faker')

const createUser = () =>{
    return{
        _id:faker.datatype.uuid(),
        first_name: faker.name.firstName(),
        last_name:faker.name.lastName(),
        email:faker.internet.email(),
        password:faker.internet.password(),
        phone_number:faker.phone.number(),
    }
}
const createCompany = () =>{
    return{
        _id:faker.datatype.uuid(),
        name:faker.name.fullName(),
        address:{
            street: faker.address.street(),
            city:faker.address.city(),
            state:faker.address.state(),
            zip:faker.address.zipCode(),
            country:faker.address.country()
        }
    }
}

app.listen(PORT,()=>{
    console.log(`Server is up and running  on ${PORT}`) //string interpulation 
})

app.get('/api/user/new',(req,res)=>{
    // console.log(req)
    console.log(req.url,req.method)
    const user = createUser()
    res.json(user)
})

app.get('/api/company/new',(req,res)=>{
    const company = createCompany()
    res.json(company)
})

app.get('/api/user/company/',(req,res)=>{
    const newCompany =createCompany()
    const newUser =createUser()
    const userCompany = {
        user: newUser,
        company:newCompany
    };
    res.json(userCompany)
})



