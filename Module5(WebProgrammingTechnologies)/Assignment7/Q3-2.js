//Q3_2

var str = prompt("Enter the String:");
const chstr = prompt('Enter a string that you want to check:');

document.write("<br> You Entered String: "+str);
document.write("<br> You Entered String: "+chstr);

function check(){
    //var len = str.length;
    if(str.endsWith(chstr)) {
        document.write("The string " +str+ " end with "+chstr);
    } else {
        document.write("The string " +str+ " does not end with "+chstr);
    }
}