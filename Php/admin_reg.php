<?php

include("conection.php");
if($SERVER_REQUEST['method'] == 'POST'){
$name=$_POST["edName"];
$phn=$_POST["edPhn"];
$address = $_POST["edadd"];
$email=$_POST["edEmail"];
$pass=$_POST["edPass"];

$sqli= "SELECT * FROM admin_reg WHERE email='$email' or phn='$phn' ";
$result= mysqli_query($con, $sqli);
if (mysqli_num_rows($result)>0){
    echo 'EXIST';
}
else{
    $sqli = "INSERT INTO admin_reg values ('','$name','$phn','$address','$email','$pass')";
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