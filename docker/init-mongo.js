db.createUser(
    {
        user: "spring-cloud",
        pwd: "spring-cloud",
        roles: [
            {
                role: "readWrite",
                db: "spring-cloud"
            }
        ]
    }
);

db = new Mongo().getDB("spring-cloud");

db.createCollection('product', { capped: false });

db.product.insert([
    { "_id": "productId1", "name": "productName1", "stock": 100, "price": 100000 },
    { "_id": "productId2", "name": "productName2", "stock": 101, "price": 100011 },
    { "_id": "productId3", "name": "productName3", "stock": 102, "price": 100002 },
    { "_id": "productId4", "name": "productName4", "stock": 103, "price": 100013 },
    { "_id": "productId5", "name": "productName5", "stock": 104, "price": 100004 },
    { "_id": "productId6", "name": "productName6", "stock": 105, "price": 100015 },
    { "_id": "productId7", "name": "productName7", "stock": 106, "price": 100006 },
    { "_id": "productId8", "name": "productName8", "stock": 107, "price": 100017 },
    { "_id": "productId9", "name": "productName9", "stock": 108, "price": 100008 },
    { "_id": "productId10", "name": "productName10", "stock": 109, "price": 100019 },
    { "_id": "productId11", "name": "productName11", "stock": 1010, "price": 1000010 },
    { "_id": "productId12", "name": "productName12", "stock": 1011, "price": 1000111 },
    { "_id": "productId13", "name": "productName13", "stock": 1012, "price": 1000012 },
    { "_id": "productId14", "name": "productName14", "stock": 1013, "price": 1000113 },
    { "_id": "productId15", "name": "productName15", "stock": 1014, "price": 1000014 },
    { "_id": "productId16", "name": "productName16", "stock": 1015, "price": 1000115 },
    { "_id": "productId17", "name": "productName17", "stock": 1016, "price": 1000016 },
    { "_id": "productId18", "name": "productName18", "stock": 1017, "price": 1000117 },
    { "_id": "productId19", "name": "productName19", "stock": 1018, "price": 1000018 },
    { "_id": "productId20", "name": "productName20", "stock": 1019, "price": 1000119 },
    { "_id": "productId21", "name": "productName21", "stock": 1020, "price": 1000020 },
    { "_id": "productId22", "name": "productName22", "stock": 1021, "price": 1000121 },
    { "_id": "productId23", "name": "productName23", "stock": 1022, "price": 1000022 },
    { "_id": "productId24", "name": "productName24", "stock": 1023, "price": 1000123 },
    { "_id": "productId25", "name": "productName25", "stock": 1024, "price": 1000024 },
    { "_id": "productId26", "name": "productName26", "stock": 1025, "price": 1000125 },
    { "_id": "productId27", "name": "productName27", "stock": 1026, "price": 1000026 },
    { "_id": "productId28", "name": "productName28", "stock": 1027, "price": 1000127 },
    { "_id": "productId29", "name": "productName29", "stock": 1028, "price": 1000028 },
    { "_id": "productId30", "name": "productName30", "stock": 1029, "price": 1000129 }
]);
