function F21(A){
    let duplicate = [];
    const tempArray = [...A].sort();
    for (let i = 0; i < tempArray.length; i++) {
        if (tempArray[i + 1] === tempArray[i]) {
          duplicate.push(tempArray[i]);
        }
      }
      if(duplicate.length>0){
          // return false;
          console.log("false")
      }else{
          // return true;
          console.log("true");
      }
}