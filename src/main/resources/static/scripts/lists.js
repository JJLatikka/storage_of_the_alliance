
function resetContainers() {
  cElements.length = 0; containers.length = 0; cSelectIndex = -1;
  cStatElements.length = 0; cChecks.length = 0;
}

function resetItems() {
  iElements.length = 0; items.length = 0; iSelectIndex = -1;
  iStatElements.length = 0; iChecks.length = 0;
}

function limitStr(s) {
  return s.length < 43 ? s : s.substring(0, 43) + "...";
}

function nOption(s) {
  let opt = document.createElement("option");
  opt.innerHTML = '<label>' + limitStr(s) + '</label>';
  return opt;
}

function sOption(b) {
  let opt = document.createElement("option");
  opt.className = "option"; let col = b ? "#FF7700" : "#7A98B4";
  let check = '<input class="checkbox" type="checkbox" ' +
    'style="background-color: ' + col + ';">';
  opt.innerHTML = check; return opt;
}

function container(j) {
  let b = j.spaceLeft;
  cElements.add(nOption(j.name)); containers.push(j);
  cStatElements.add(sOption(b)); cChecks.push(b);
}

function updateContainers() {
  fetch(cURL).then(r => r.json()).then(o => { resetContainers();
    o.forEach(j => container(j)); }).catch(e => null);
}

function editContainer(cha) {
  let c = containers[cha[0]]; c.spaceLeft = cha[1]; cChecks[cha[0]] = cha[1];
  fetch(cURL, { method: "PUT", headers: { "Content-Type": "application/json" },
    body: JSON.stringify(c) }).catch(e => null);
}

function item(j) {
  let b = j.removed;
  iElements.add(nOption(j.name)); items.push(j);
  iStatElements.add(sOption(b)); iChecks.push(b);
}

function updateItems(i) {
  fetch(iURL + "/" + i).then(r => r.json()).then(o => { resetItems();
    o.forEach(j => item(j)); }).catch(e => null);
}

function editItem(cha) {
  let i = items[cha[0]]; i.removed = cha[1]; iChecks[cha[0]] = cha[1];
  fetch(iURL, { method: "PUT", headers: { "Content-Type": "application/json" },
    body: JSON.stringify(i) }).catch(e => null);
}
