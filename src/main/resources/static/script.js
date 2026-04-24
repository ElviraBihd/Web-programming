const moviesTable = document.getElementById("deviceTableBody");

//load movies
document.getElementById("loadMovies").addEventListener("click", async ()=> {
    const response = await fetch("/api/movies");
    const data = await response.json();
    moviesTable.innerHTML = "";
    data.forEach(movie => addMovieRow(movie))
});

// add movies dynamically to html
function addMovieRow(movie){
    const row = document.createElement("tr")
    row.innerHTML = `
    <td>${movie.id}</td>
    <td>${movie.name}</td>
    <td>${movie.age_limit}</td>
    <td>${movie.type}</td>
    <td>${movie.director}</td>
    
    <td>
    <button class="btn btn-warning btn-sm btn-edit">Edit</button>
    <button class="btn btn-warning btn-sm btn-edit">Delete</button>
</td>
    `
    moviesTable.append(row);
}

// new empty row
document.getElementById("addRow").addEventListener("click", () => {
    const row = document.createElement("tr");
    row.innerHTML = `
    <td>-</td>
    <td><input class="form-control" type="text"</td>
    <td><input class="form-control" type="number"</td>
    <td><input class="form-control" type="text"</td>
    <td><input class="form-control" type="text"</td>
    <td>
        <button class="btn btn-primary btn-sm btn-save">Save</button>
        <button class="btn btn-primary btn-sm btn-save">Cancel</button>
    </td>
    `

    moviesTable.append(row);
    row.querySelector(".btn-save").addEventListener("click", () => saveRow(row))
})

async function saveRow(row){
    const inputs = row.querySelectorAll("input");
    const object = {
        name: inputs[0].value.trim(),
        age_limit: Number(inputs[1].value.trim()),
        type: inputs[2].value.trim(),
        director: inputs[3].value.trim(),
    };

    //core to how frontend talks to Spring Boot backend, sends data from  browser →  Spring controller
    const response = await fetch("api/movies", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload)

    })
}