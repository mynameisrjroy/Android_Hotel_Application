<?php

include("conection.php");
if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $name=$_POST["edName"];
    $phn=$_POST["edPhn"];
    $email=$_POST["edEmail"];
    $price=$_POST["edRoomPrice"];
    $checkin=$_POST["edCheckin"];
    $checkout=$_POST["edCheckout"]

// $name = 'ap';
// $phn ='098755';
// $email = 'E@gamil.com';
// $pass = '1234';


$sqli = "INSERT INTO room_book values (0,'$name','$phn','$email','$price','$checkin','$checkout')";
if(!mysqli_query($con, $sqli))
{
    echo 'Not Inserted';
}
else{
    echo 'Inserted';
}




}

?>