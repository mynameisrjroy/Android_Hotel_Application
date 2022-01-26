<?php

include("conection.php");
if($SERVER_REQUEST['method'] == 'POST'){
$name=$_POST["edName"];
$phn=$_POST["edPhn"];
$email=$_POST["edEmail"];
$pass=$_POST["edPass"];

// $name = 'ap';
// $phn ='098755';
// $email = 'E@gamil.com';
// $pass = '1234';

$sqli= "SELECT * FROM user_reg WHERE email='$email' or phn='$phn' ";
$result= mysqli_query($con, $sqli);
if (mysqli_num_rows($result)>0){
    echo 'EXIST';
}
else{
$sqli = "INSERT INTO user_reg values (0,'$name','$phn','$email','$pass')";
if(!mysqli_query($con, $sqli))
{
    echo 'Not Inserted';
}
else{
    echo 'Inserted';
}

}

}

?>