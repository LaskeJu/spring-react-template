import React, { useState, useEffect } from "react";
import UserService from "../services/UserService";
import IUser from "../types/User";

const UserList: React.FC = () => {
    const [users, setUsers] = useState<Array<IUser>>([]);

    useEffect(() => {
        getUsers();
    }, []);

    const getUsers = () => {
        UserService.getAll()
            .then((response: any) => {
                setUsers(response.data);
                console.log(response.data);
            })
            .catch((e: Error) => {
                console.log(e);
            });
    };

    return (
        <div>
            <h1>User</h1>
            <ul>
                {users &&
                users.map((user, index) => (
                <li>
                    {user.firstName} {user.lastName}
                </li>
                ))}
            </ul>
        </div>
    );
};

export default UserList;