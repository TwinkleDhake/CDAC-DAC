// Q2
//num="1,2,3,4,5,6,7,8,9"
var num = [1,2,3,4,5,6,7,8,9];
var i = 0;

//1.Print only numbers not comma using array
function not_comma(){
        document.write("<br>1.Print only numbers not comma");
        document.write("<br>Convert array to comma seperated string :" + num.toString());
		//document.write("<br>Convert array to pipe seperated string :" + num.join("|"));
        document.write("<br>Convert array to without comma seperated string :" + num.join(" "));
}

//1.Print only numbers not comma using str function
function not_comm_str(){
    document.write("<br>1.Print only numbers not comma using str function");
    document.write("<br>" +num.join(" "));
    }


//2.Print all even numbers
function even_num(){
    document.write("<br>2.Print all even numbers: ");
    for(i=0; i<num.length; i++){
        if(num[i]%2==0)
        {
            document.write(" " +num[i]);
        }
    }
}

//3.Fetch "1" and "5" from string and perform numerical addition
function addition(){
    document.write("<br>3. Fetch 1 and 5 from string and perform numerical addition: ");
    for(i=0; i<num.length; i++)
    {
        if(num[i]==1)
        {
            var a = num[i];
        }
    }
    for(i=0; i<num.length; i++){
    if(num[i]==5)
            {
                var b = num[i];
            }
    }
    document.write(a+b); 
}
 
//or
//3.Fetch "1" and "5" from string and perform numerical addition using string function
function add_str(){
    document.write("<br>3.Fetch 1 and 5 from string and perform numerical addition using string function");
    var a = num.indexOf(1);
    var b = num.indexOf(5);
    var c = num[a] + num[b];
    document.write("<br> Addition of 1 and 5: " +c);

}

//4.Fetch "2" and "8" from string and perfrom numerical muliplication
function muliplication(){
    document.write("<br>4. Fetch 2 and 8 from string and perfrom numerical muliplication: ");
    for(i=0; i<num.length; i++)
    {
        if(num[i]==2)
        {
            var d = num[i];
        }
    }
    for(i=0; i<num.length; i++){
        if(num[i]==8)
            {
                var e = num[i];
            }
        }
    document.write(d*e);

}

//or
//4. Fetch "2" and "8" from string and perfrom numerical muliplication using string function
function mul_str(){
    document.write("<br>4.Fetch 2 and 8 from string and perfrom numerical muliplication");
    var a = num.indexOf(2);
    var b = num.indexOf(8);
    var c = num[a] * num[b];
    document.write("<br> Multiplication of 2 and 8: " +c);

}