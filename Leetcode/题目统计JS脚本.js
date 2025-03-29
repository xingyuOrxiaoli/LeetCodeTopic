var arr = [] ;
var rows = document.getElementsByClassName("flex-col")[3].children[1].children[0].children[1].children;
for(var i = 0 ; i < 46 ;i++){
    console.log(rows[i].children[0].children[1].children[0].children[0].children[1].children[0].children[0].innerText)
    console.log( i + rows[i].children[0].children[2].children[0].innerText )
    if(rows[i].children[0].children[2].children[0].innerText == "通过") {
        arr[i] = rows[i].children[0].children[1].children[0].children[0].children[1].children[0].children[0].innerText;
    }
}
console.log(arr);

