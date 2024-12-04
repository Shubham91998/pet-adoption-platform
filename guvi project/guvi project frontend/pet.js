const mongoose = require('mongoose');
require('dotenv').config();

mongoose.connect("mongodb://localhost:27017/yourDatabase", {
    useNewUrlParser: true,
    useUnifiedTopology: true
})
.then(() => console.log("Connected to local MongoDB"))
.catch((err) => console.error("Could not connect to MongoDB", err));
