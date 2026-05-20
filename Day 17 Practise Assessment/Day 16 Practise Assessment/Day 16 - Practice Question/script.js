function getUser() {
  fetch("https://randomuser.me/api/")
    .then((response) => response.json())
    .then((data) => {
      console.log(data);

      let user = data.results[0];

      let output = `
            <h2>${user.name.first} ${user.name.last}</h2>

            <p><strong>Email:</strong> ${user.email}</p>

            <img src="${user.picture.large}" width="150">
        `;

      document.getElementById("result").innerHTML = output;
    })

    .catch((error) => {
      console.log("Error:", error);
    });
}
