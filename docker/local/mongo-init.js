db.createUser(
    {
        user: "ingredient_app",
        pwd: "in9r3d1Ent!$",
        roles: [
            {
                role: "readWrite",
                db: "ingredient"
            }
        ]
    }
);