<?php

include("conection.php");
if($_SERVER['REQUEST_METHOD'] == 'POST'){


// $sql = "SELECT * FROM hotel";
// $result = $conn->query($sql);

// $r = array();

// while($row = mysqli_fetch_array($result)){
//     array_push($r,array(
//         'Hotel Image'=>$row['img'],
//         'Hotel Name'=>$row['hotel_name'],
//         'Description'=>$row['description'],
//         'Address'=>$row['address'],
//         'Rating'=>$row['rating'],
//         'Contact Us'=>$row['contact_us']
//     ));
// }

// echo json_encode(array('result'=>$result));

// mysqli_close($con);




$sql = "SELECT * FROM hotel";

$result = $con->query($sql);



if($result->num_rows > 0)
{
    while($row = $result->fetch_assoc()) {
    echo " Hotel Image: " . $row["img"]. "<br>" . 
    " Hotel Name: " . $row["hotel_name"]. "<br>" .
    " Description: " . $row["description"]. "<br>".
    " Address: " . $row["address"]. "<br>".
    " Rating: " . $row["rating"]. "<br>".
    " Contact Us: " . $row["contact_us"]. "<br>";
  }
}
else{
    echo 'Not Fetch';
}






}

}
?>