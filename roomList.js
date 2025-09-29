let selectedRoom = null;

document.querySelectorAll(".room-item").forEach(div => {
    div.addEventListener("click", function() {
        let classroomId;
        let roomId;
        let classroom;
        let room;

        if (this === selectedRoom) {
            selectedRoom.classList.remove("selected");
            selectedRoom = null;
            document.getElementById('editorForm').reset();
        } else {
            if(selectedRoom) {
                selectedRoom.classList.remove("selected");
            }
            this.classList.add("selected");
            selectedRoom = this;

            classroomId = Number(this.dataset.id);
            // classroomId = classroom.id;
            classroom = classrooms.find(x => x.id == classroomId);
            roomId = Number(classroom.room.id);
            // roomId = classroom.room.id; //이건 되는되 왜 classroomId는 안 됨? th:value라서 dataset으로면 연결되는건가?
            room = rooms.find(x => x.id == roomId)
        }
        
        if (classroom) {
            document.getElementById("roomBuilding").value = room.building;
            document.getElementById("roomId").value = roomId;
            document.getElementById("roomNumber").value = room.number;
            if (room.floor < 0) {
                document.getElementById("minus").checked = true;
            } else {
                document.getElementById("minus").checked = false;
            }
            document.getElementById("name").value = classroom.name;
            document.getElementById("direction").value = classroom.direction;
            document.getElementById("type").value = classroom.type;
            document.getElementById("count").value = classroom.count;
            document.getElementById("parent").value = classroom.parent;
        }
    })
})