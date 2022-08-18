var Fruit_Shop=[]

function add_fruit()
{
    var fruit_id=prompt("Enter fruit ID");
    var name=prompt("Enter fruit name ");

    var rate=prompt("Enter rate of fruit");

    Fruit_Shop.push(
    {
        fruit_id:fruit_id,
        name:name,
        rate:rate
    })
}

function display_fruit()
{
    var str="<table border=1>"
    for(var i=0; i<Fruit_Shop.length; i++)
    {
        str = str + "<tr><td>"+Fruit_Shop[i].fruit_id+"</td>"+"<td>"+Fruit_Shop[i].name+"</td>"+"<td>"+Fruit_Shop[i].rate+"</td>";

    }
    str = str + "<table>";
    document.write(str);
}