import http from "../http-common";
import IUser from "../types/User";

const getAll = () => {
    return http.get<Array<IUser>>("/users");
};

const UserService = {
    getAll,
};

export default UserService;