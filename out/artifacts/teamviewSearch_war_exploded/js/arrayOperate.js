function unique1(arr){
    var tmpArr = [];
    for(var i=0; i<arr.length; i++){
        //如果当前数组的第i已经保存进了临时数组，那么跳过，
        //否则把当前项push到临时数组里面
      if(tmpArr.indexOf(arr[i]) == -1){
        tmpArr.push(arr[i]);
      }
    }
    return tmpArr;
  }