import axios from "axios";
const baseurl = "http://localhost:8080/";
class DataFetch{
    init(){
        axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
        axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
        const token = localStorage.getItem("token");
        if (token) {
            setAuthToken(token);
        }
    }

    static login(username,password){
        return new Promise((resolve, reject) => {
            axios.post(baseurl+"login", {
                "password": password,
                "username": username
            })
                .then(response => {
                    const token  =  response.data.token;
                    localStorage.setItem("token", token);
                    localStorage.setItem("role",response.data.userEntity.role);
                    localStorage.setItem("uuid",response.data.userEntity.uuid);
                    setAuthToken(token);
                    resolve({status: true});
                })
                .catch(err => {
                    reject({status: false,message: getErrorHandled(err)});
                });
        })

    }

    static accounts(limit){
        return new Promise((resolve, reject) => {
            axios.get(baseurl+"accounts/id/"+localStorage.getItem("uuid"), limit)
                .then(response => {
                    console.log(response)
                    resolve({status: true});
                })
                .catch(err => {
                    reject({status: false,message: getErrorHandled(err)});
                });
        })

    }

}
function  getErrorHandled(err){
    console.log(err);
    // if(err.status === 500){
    //
    // }
    return err.response.data.message;
}

export const setAuthToken = token => {
    if (token) {
        axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
    }
    else
        delete axios.defaults.headers.common["Authorization"];
}

export default DataFetch;