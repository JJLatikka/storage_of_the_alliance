
function shape(keys, d, str) {
  keys.forEach(c => { str += ["\n", tab1, c, " :"].join("");
    d[c].forEach(i => { str += ["\n", tab2, i].join("");
      }); str += "\n"; }); return str;
}

function showResults(d) {
  results.innerHTML = ""; let keys = Object.keys(d);
  let text = keys.length == 0 ? ["\n", tab1, "Ei näytettävää."].join("") :
    shape(keys, d, ""); results.appendChild(document.createTextNode(text));
}

function find() {
  buttons.style.display = "none"; findItemElement.style.display = "grid";
}

function hideFindI() {
  findItemElement.style.display = "none"; buttons.style.display = "grid";
  iToFindName.value = "";
}

function findItem() {
  let name = iToFindName.value;
  if (name != "") {
    let url = [iURL, "/", "'", name, "'"].join("");
    fetch(url).then(r => r.json()).then(o => { let d = {}; o.forEach(j => {
      let k = containers.filter(c => c.id == j.containerId)[0].name;
      !Object.keys(d).includes(k) ? d[k] = [j.name] : d[k].push(j.name);
    }); hideFindI(); showResults(d); }).catch(e => null);
  }
}

function add() {
  if (cSelectIndex == -1) {
    buttons.style.display = "none"; addContainerElement.style.display = "grid";
  } else {
    buttons.style.display = "none"; feedback.style.display = "none";
    addItemsElement.style.display = "flex";
  }
}

function hideAddC() {
  addContainerElement.style.display = "none"; buttons.style.display = "grid";
  cToAddName.value = "";
}

function hideAddI() {
  addItemsElement.style.display = "none"; buttons.style.display = "grid";
  feedback.style.display = "flex"; iToAddNames.forEach(e => { e.value = ""; });
}

function addContainer() {
  let name = cToAddName.value;
  fetch(cURL, { method: "POST", headers: { "Content-Type": "application/json" },
    body: '{"name":"' + name + '"}' }).then(r => r.json()).then(o => { let a = o.alert;
      a != null ? (() => { hideAddC(); alert(a); })() : hideAddC(); updateContainers(); })
      .catch(e => null);
}

function jStrList(cId) {
  let l = [];
  iToAddNames.forEach(e => {
    let s = e.value; let jS = s == "" ? null :
    '{"name":"' + s + '","containerId":' + cId + '}';
    jS != null ? l.push(jS) : -1;
  });
  return l.length != 0 ? ["[", l.join(","), "]"].join("") : null;
}

function addItems() {
  let c = containers[cSelectIndex]; let jSL = jStrList(c.id);
  if (jSL != null) {
    fetch(iURL, { method: "POST", headers: { "Content-Type": "application/json" },
      body: jSL }).then(r => { hideAddI(); updateItems(c.id); c.empty = false;
        }).catch(e => null);
  }
}

function del() {
  if (cSelectIndex != -1) {
    if (iSelectIndex == -1) {
      fetch(cURL, { method: "DELETE", headers: { "Content-Type": "application/json" },
        body: JSON.stringify(containers[cSelectIndex]) }).then(r => r.json()).then(o => {
          let a = o.alert; a != null ? alert(a) : updateContainers(); }).catch(e => null);
    } else {
      let n = items.length; let c = containers[cSelectIndex];
      fetch(iURL, { method: "DELETE", headers: { "Content-Type": "application/json" },
        body: JSON.stringify(items[iSelectIndex]) }).then(r => { c.empty = n - 1 == 0;
          updateItems(c.id); cStatElements[cSelectIndex] = sOption(true);
          editContainer([cSelectIndex, true]); }).catch(e => null);
    }
  }
}

updateContainers();
