console.log("Script carregado com sucesso!");

const buttonAddTask = document.getElementById("buttonAddTask");

buttonAddTask.addEventListener("click", function(event) {
    event.preventDefault();

    const taskName = document.getElementById("taskName").value;
    const taskDescription = document.getElementById("taskDescription").value;

    console.log("Tarefa adicionada:", taskName, taskDescription);

    addTaskToBackend(taskName, taskDescription);
});

const buttonListTask = document.getElementById("buttonListTask");
buttonListTask.addEventListener("click", function(event) {
    event.preventDefault();
    console.log("Listar tarefas clicado");
    listTasksFromBackend();
});

const buttonExcludeTask = document.getElementById("buttonDeleteTask");
buttonExcludeTask.addEventListener("click", function(event) {
    console.log("Cheguei aqui");
    const taskId = document.getElementById("taskId").value;
    event.preventDefault();
    console.log("Deletar tarefa pelo id");
    deleteTaskFromBackend(taskId);
});

const buttonUpdateTask = document.getElementById("buttonUpdateTask");
buttonUpdateTask.addEventListener("click", function(event) {
    event.preventDefault;
    const taskUpdateId = document.getElementById("updateTaskId").value;
    const taskUpdateName = document.getElementById("updateTaskName").value;
    const taskUpdateDescription = document.getElementById("updateTaskDescription").value;
    updataTaskFromBackend(taskUpdateId, taskUpdateName, taskUpdateDescription);
});

const buttonConcludeTask = document.getElementById("buttonCompleteTask");
buttonConcludeTask.addEventListener("click", function(event) {
    event.preventDefault;
    const taskConcludeId = document.getElementById("completeTaskId").value;
    concludeTaskFromBackend(taskConcludeId);
})