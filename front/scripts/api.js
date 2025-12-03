function addTaskToBackend(taskName, taskDescription) {
    const taskData = {
        taskName: taskName,
        taskDescription: taskDescription
    };

    fetch("http://localhost:8080/task/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
    },
        body: JSON.stringify(taskData)
})
    .then(response => response.json())
    .then(data => {
        console.log("Tarefa enviada ao backend com sucesso:\n", data);
        alert("Tarefa adicionada com sucesso!");
    })
    .catch(error => {
        console.error("Erro ao enviar tarefa ao backend:\n", error);
        alert("Ocorreu um erro ao tentar criar a tarefa.");
    });
}

function listTasksFromBackend() {
    fetch("http://localhost:8080/task/list-tasks")
    .then(response => response.json())
    .then(data => {
        const tasksList = document.getElementById("taskList");
        tasksList.innerHTML = '';
        data.forEach(task => {
        const listItem = document.createElement("li");
        listItem.textContent = `ID: ${task.id} | Tarefa: ${task.name} | Status: ${task.status || 'Não informado'}`;
        tasksList.appendChild(listItem);
    })
    console.log("Tarefas listadas do backend com sucesso:\n", data);
    alert("Tarefas listadas com sucesso!");
    })
    .catch(error => {
        console.error("Erro ao listar tarefas do backend:\n", error);
        alert("Ocorreu um erro ao tentar listar as tarefas.");
    });
}

function deleteTaskFromBackend(taskId) {
    fetch(`http://localhost:8080/task/${taskId}/delete`, {method: "DELETE"})
    .then(response => response.json())
    .then(data => {
        console.log("Tarefa solicitada para excluir:\n", data);
        alert("Tarefa excluida com sucesso!");
    })
    .catch(error => {
        console.error("Erro ao excluir a tarefa solicitada:\n", error);
        alert("Ocorreu um erro ao tentar exlcuir a tarefa solicitada.");
    });
}

function updataTaskFromBackend(id, name, description) {
    const taskBody = {
        "taskName": name,
        "taskDescription": description
    };
    
    fetch(`http://localhost:8080/task/update/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(taskBody)
    })
    .then(response => response.json())
    .then(data => {
        console.log("Tarefa solicitada para atualização:\n", data);
        alert("Tarefa alterada com sucesso!");
    })
    .catch(error => {
        console.error("Erro ao excluir a tarefa solicitada:\n", error);
        alert("Erro ao alterar tarefa!")
    });
}

function concludeTaskFromBackend(id) {
    fetch(`http://localhost:8080/task/${id}/conclude`)
    .then(response => response.json())
    .then(data => {
        console.log("Tarefa Conluída!\n", data);
        alert("Tarefa concluída com sucesso!");
    })
    .catch(error => {
        console.log("Erro ao concluir tarefa:\n", error);
        alert("Erro ao concluir tarefa!")
    });
}