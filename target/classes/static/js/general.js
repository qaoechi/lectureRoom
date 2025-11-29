function getListItem(list, field, id) {
    return list.find(x => x[field] == id);
}

function preventSubmit(form, message, bool, event) {
    if (bool) {
        alert(message);
        form.focus();
        event.preventDefault();
        throw new Error(message);
    }
}

function selectDiv(div) {
    let classroom, classroomId, room;
    if (div === selectedRoom) {
        selectedRoom.classList.remove("selected");
        selectedRoom = null;
        origin = null;
    } else {
        if(selectedRoom) {
            selectedRoom.classList.remove("selected");
        }
        div.classList.add("selected");
        selectedRoom = div;

        classroomId = Number(div.dataset.id);
        // classroom = classrooms.find(x => x.id == classroomId);
        classroom = getListItem(classrooms, "id", classroomId);
        let roomId = Number(classroom.room.roomId);
        // room = rooms.find(x => x.roomId == roomId);
        room = getListItem(rooms, "roomId", roomId);
        origin = classroom.parent;
    }

    reset();
    if (classroom) {
        document.getElementById("building").value = room.building;
        document.getElementById("classroomId").value = classroomId;
        document.getElementById("number").value = room.number;
        (room.floor < 0) ? floorCheck(true): floorCheck(false);
        document.getElementById("name").value = classroom.name;
        document.getElementById("direction").value = classroom.direction;
        document.getElementById("type").value = classroom.type;
        document.getElementById("count").value = classroom.count;
        classroom.parent ? fillParentForm(classroom.parent.id) : null;
        document.getElementById("memo").value = classroom.memo;
    };
}

function reset() {
    document.getElementById("editorForm").reset();
    removeParentForm();
}

function floorCheck(bool) {
    document.getElementById("floor").checked = bool;
}



function recursionParent(id, classroomId, visited = new Set()) {
    const parent = getListItem(classrooms, "id", id);
    if (!parent) return false;

    if (visited.has(parent.id)) return true;
    visited.add(parent.id);

    if (!parent.parent) return false;

    if(parent.parent.id == classroomId) return true;

    return recursionParent(parent.parent.id, classroomId, visited);
}