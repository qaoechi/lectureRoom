document.querySelectorAll(".room-item").forEach(div => {
    div.addEventListener("dragstart", event => {
        event.dataTransfer.setData("text/plain", event.target.dataset.id);
    })
})

document.getElementById("dropZone").addEventListener("dragover", event => {
    event.preventDefault(); //div를 둘때 dragover라는 이벤트를 발행해서 이걸 해야함
    
})

document.getElementById("dropZone").addEventListener("drop", function(event) {
    event.preventDefault();
    if (selectedRoom == null) return;
    const id = event.dataTransfer.getData("text/plain");
    const classroom = classrooms.find(x => x.id == id);
    this.textContent = classroom.room.number + "" + classroom.name;
    document.getElementById("parentId").value = id;
})

document.getElementById("dropZone").addEventListener("click", function() {
    if (this.textContent != null) {
        this.textContent = "부모 강의실";
        document.getElementById("parentId").value = "";
    }
})

document.getElementById("parentId").addEventListener("input", function() {
    const classroom = getListItem(classrooms, "id", this.value);
    document.getElementById("dropZone").textContent = classroom.room.number + "" + classroom.name;
    //수정인 아닌 생성 상태에서 drop하면 내용이 추가, 선택되지 않음
})

function fillParentForm(id) {
    const parent = classrooms.find(x => x.id == id);
    document.getElementById("dropZone").textContent = parent.room.number + "" + parent.name;
    document.getElementById("parentId").value = String(parent.id);
}
function removeParentForm() {
    document.getElementById("dropZone").textContent = "부모 강의실";
}