document.getElementById("editorForm").addEventListener("submit", event => {
    const building = document.getElementById("building");
    const number = document.getElementById("number");
    const classroomId = document.getElementById("classroomId");
    const direction = document.getElementById("direction");
    const type = document.getElementById("type");
    const count = document.getElementById("count");
    const parent = document.getElementById("parentId");

    try {
        preventSubmit(number, "호수를 입력하세요(없다면 층만 기입)", number.value === "",  event);
        preventSubmit(number, "호수가 너무 깁니다.", number.value.length > 6, event);
        preventSubmit(number, "숫자와 -(하이픈) 만 입력하세요", !(/^[0-9-]+$/.test(number.value)), event);
        preventSubmit(number, "하이픈(-)만 입력하지 마세요", number.value.length == 1 && number.value == "-", event);
        preventSubmit(number, "하이픈(-)으로 끝내지 마세요", number.value[number.value.length - 1] == "-", event);
        preventSubmit(count,"문의 수를 입력하세요", count.value === "", event);
        preventSubmit(count,"0이상 자연수를 입력하세요", count.value < 0, event);
        preventSubmit(count,"숫자가 아닙니다", !Number.isFinite(Number(count.value)), event);
        preventSubmit(type, "문 종류를 선택하세요", type.value === "", event);
        preventSubmit(direction, "방향을 선택하세요", direction.value === "", event);
        preventSubmit(building, "건물을 선택하세요", building.value === "", event);    
        preventSubmit(parent, "자신을 참조하지 마세요", !classroomId &&  parent.value === classroomId.value, event);
        preventSubmit(parent, "순환참조 금지", recursionParent(parent.value, classroomId.value), event);

    } catch (e) {
        console.log(e.message);
    }

})