let selectedRoom = null;

document.querySelectorAll(".room-item").forEach(div => {
    div.addEventListener("click", function() {
        selectDiv(this);
    })
})

document.getElementById("building").addEventListener("", function() {
    //이 select의 값이 선택되면 parent의 select가 값이 변경되도록
    //근데 이러면 드래그로 선택하는 방법은 없어지잖아. 그냥 수정으로 건물이 바뀌면 자식 설정은 수정 후 또 수정으로 하는게 맞나?
})

document.getElementById("classroomId").addEventListener("input", function() {
    let id = this.value;
    selectDiv(document.querySelector(`div[data-id="${id}"]`));
})