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
