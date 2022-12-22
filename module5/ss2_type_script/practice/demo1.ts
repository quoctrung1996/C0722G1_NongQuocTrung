
let connetDB=function (user:string,pass:string) {
    // @ts-ignore
    return new Promise(function (resolve, reject){
        setTimeout(function (){
            if (user=="admin" && pass=="123"){
                return resolve ("thành công");
            }else {
                return reject("Thất bại");
            }
        },1000);
    })
}
connetDB("admin","123")
.then(data=> console.log("Ok"+data))
.catch(err=> console.log("Ok"+err))
let x :number=1;
let x1="alo";
let list:number[]=[1,2,3];
let list1:Array<number>=[1,2,3];
let tuple:[string,number];
tuple=["alo",1];