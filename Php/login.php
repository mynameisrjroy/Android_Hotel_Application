<?php
include("conection.php");
if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $email = $_POST['edUser'];
    $pass = $_POST['edPass'];

    $sqli= "SELECT * FROM user_reg WHERE email='$email' && pass='$pass' ";

    $res = mysqli_query($con, $sqli);

    if(mysqli_num_rows($res) == 1){
        echo "Login Successful";
    }else{
        echo "Login Unsuccessful";
    }








}
?>