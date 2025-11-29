async function loadLogs(link) {
    try {
        const response = await fetch(link);
        if (!response.ok) throw new Error("서버 오류");
        return await response.json();
    } catch (e) {
        console.error(e);
    }
}

document.querySelectorAll(".history-item").forEach(div => {
    div.addEventListener("click", async function() {
        const link = '/jumjari/client/classroom/' + engShort + '/history/' + this.dataset.id;
        const list = await loadLogs(link);
        const roomList = document.getElementById("history");

        while (roomList.firstChild) {
            roomList.firstChild.remove();
        }

        console.log(this.dataset.id);
        list.forEach(item => {
            
            const div = document.createElement("div");
            div.classList.add("doma-item");

            // console.log(item);
            div.textContent = compare(JSON.parse(item.before), JSON.parse(item.after));
            let classroom = getListItem(classrooms, Number(item.classroomId));

            div.dataset.id = item.id;

            roomList.appendChild(div);
            //그 이런 느낌임
        })
    })
})

function compare(before, after) {
    if (!after) return "after가 없음";
    if (before == null) return "create";
    afterKey = Object.keys(after);
    beforeKey = Object.keys(before);
    if (afterKey.length == 1 && afterKey[0] == "actived") return "inactive";

    let result = "";
    beforeKey.forEach(k => {
        result += k + ": " + before[k] + "→" + after[k] + "\n";
    })

    console.log(result);
    return result;
}

document.querySelectorAll(".doma-item");