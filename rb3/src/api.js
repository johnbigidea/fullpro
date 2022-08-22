import axios from 'axios'
import qs from 'qs'

const api = ""
axios.defaults.headers = {
    'Content-type': 'application/x-www-form-urlencoded'
}

//get
export const getallw  =(a) =>{
    return axios.post(`${api}/employee/getallemployees`,qs.stringify(a))
}

// export const getalleq  =() =>{
//     return axios.get(`${api}/employee/getallequal`)
// }

// export const getallcom  =() =>{
//     return axios.get(`${api}/employee/getallcomplex`)
// }

// export const getallsim  =() =>{
//     return axios.get(`${api}/employee/getallsimple`)
// }

// export const getalllo  =() =>{
//     return axios.get(`${api}/employee/getalllogic`)
// }

// export const getallque  =() =>{
//     return axios.get(`${api}/employee/getallquestion`)
// }

// export const getallim  =() =>{
//     return axios.get(`${api}/employee/getallimagine`)
// }

// export const getallwr  =() =>{
//     return axios.get(`${api}/employee/getallwrongway`)
// }

// export const getallex  =() =>{
//     return axios.get(`${api}/employee/getallexmaple`)
// }


//get
export const getallbyname  =(data) =>{
    return axios.post(`${api}/employee/searchsamedefine`,qs.stringify(data))
}

//get
export const getallcontainname  =(data) =>{
    return axios.post(`${api}/employee/searchsamecontain`,qs.stringify(data))
}

//create
export const createw  =(data) =>{
    return axios.post(`${api}/employee/createemployee`,qs.stringify(data))
}

export const createeq  =(data) =>{
    return axios.post(`${api}/employee/createequal`,qs.stringify(data))
}

export const createcom  =(data) =>{
    return axios.post(`${api}/employee/createcomplex`,qs.stringify(data))
}

export const createsim  =(data) =>{
    return axios.post(`${api}/employee/createsimple`,qs.stringify(data))
}

export const createlo  =(data) =>{
    return axios.post(`${api}/employee/createlogic`,qs.stringify(data))
}

export const createque  =(data) =>{
    return axios.post(`${api}/employee/createquestion`,qs.stringify(data))
}

export const createim  =(data) =>{
    return axios.post(`${api}/employee/createimagine`,qs.stringify(data))
}

export const createwr  =(data) =>{
    return axios.post(`${api}/employee/createwrongway`,qs.stringify(data))
}

export const createex  =(data) =>{
    return axios.post(`${api}/employee/createexmaple`,qs.stringify(data))
}



//delete
export const dw  =(data) =>{
    return axios.delete(`${api}/employee/deleteemployee`+'/'+data)
}

export const deq  =(data) =>{
    return axios.delete(`${api}/employee/deleteequal`+'/'+data)
}

export const dcom  =(data) =>{
    return axios.delete(`${api}/employee/deletecomplex`+'/'+data)
}

export const dsim  =(data) =>{
    return axios.delete(`${api}/employee/deletesimple`+'/'+data)
}

export const dlo  =(data) =>{
    return axios.delete(`${api}/employee/deletelogic`+'/'+data)
}

export const dque  =(data) =>{
    return axios.delete(`${api}/employee/deletequestion`+'/'+data)
}

export const dim  =(data) =>{
    return axios.delete(`${api}/employee/deleteimagine`+'/'+data)
}

export const dwr  =(data) =>{
    return axios.delete(`${api}/employee/deletewrongway`+'/'+data)
}

export const dex  =(data) =>{
    return axios.delete(`${api}/employee/deleteexmaple`+'/'+data)



    


    
}



//insert
export const insertw  =(data) =>{
    return axios.put(`${api}/employee/updateemployee`,qs.stringify(data))
}

export const inserteq  =(data) =>{
    return axios.put(`${api}/employee/updateequal`,qs.stringify(data))
}

export const insertcom  =(data) =>{
    return axios.put(`${api}/employee/updatecomplex`,qs.stringify(data))
}

export const insertsim  =(data) =>{
    return axios.put(`${api}/employee/updatesimple`,qs.stringify(data))
}

export const insertlo  =(data) =>{
    return axios.put(`${api}/employee/updatelogic`,qs.stringify(data))
}

export const insertque  =(data) =>{
    return axios.put(`${api}/employee/updatequestion`,qs.stringify(data))
}

export const insertim  =(data) =>{
    return axios.put(`${api}/employee/updateemployee`,qs.stringify(data))
}

export const insertwr  =(data) =>{
    return axios.put(`${api}/employee/updateemployee`,qs.stringify(data))
}

export const insertex  =(data) =>{
    return axios.put(`${api}/employee/updateemployee`,qs.stringify(data))
  
}