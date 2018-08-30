<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "hackathon_ubaya";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
} 

$username = mysqli_real_escape_string($conn, $_POST['username']);
$password = mysqli_real_escape_string($conn, $_POST['password']);
$role = mysqli_real_escape_string($conn, $_POST['role']);
$status = mysqli_real_escape_string($conn, $_POST['status']);
$tglupload = date('YmdHis');
$file_name = basename($tglupload . $_FILES["file"]["name"]);

$target_dir = "images/gallery/";
$target_file = $target_dir . $tglupload . $_FILES['file']['name'];
$uploadOk = 1;

            //BATASI FILE CUMAN 5MB
if ($_FILES["file"]["size"] > 5485760) {
	echo "Sorry, your file is too large.";
	$uploadOk = 0;
}
if ($uploadOk == 0) {
	echo "Sorry, your file was not uploaded.";
                // if everything is ok, try to upload file
} else {
	if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file)) {
		$sql = "INSERT INTO user (username, password, role, foto, status)
		VALUES ('$username', '$password', '$role', '$foto' ,'$status')";
		if ($conn->query($sql) === TRUE) {
			echo "New record created successfully";
		} else {
			echo "Error: " . $sql . "<br>" . $conn->error;
		}
	} else {
		echo "GAGAL UPLOAD FOTO";
	}
}





$conn->close();
?>