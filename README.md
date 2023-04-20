<!DOCTYPE html>
<html>

<body>
	<h1>Contoh Vendor Endpoint </h1>
	<table>
		<thead>
			<tr>
				<th>Endpoint</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>POST http://localhost:8080/vendors</td>
			</tr>
			<tr>
				<td>
					Request:<br>
					<pre>
{
    "name": "Vendor 1",
    "address": "123 Main St",
    "phoneNumber": "1234567890"
}
					</pre>
				</td>
			</tr>
			<tr>
				<td>
					Response:<br>
					<pre>
{
    "id": 1,
    "vendoruuid": "2c2fb10f-b21d-4a43-ae37-84cc1bb0ccae",
    "name": "Vendor 1",
    "address": "123 Main St",
    "phoneNumber": "1234567890"
}
					</pre>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
