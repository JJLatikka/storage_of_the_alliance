
containerList.addEventListener("mouseover", () => {
  cListMouse = true; cStatMouse = false;
});

containerList.addEventListener("scroll", () => {
  cListScroll = containerList.scrollTop;
  if (cListMouse) {
    cStatus.scrollTop = cListScroll;
  }
});

containerList.addEventListener("click", () => {
  let i = cElements.selectedIndex;
  cSelectIndex = cSelectIndex != i ? i : -1;
  cElements.selectedIndex = cSelectIndex;
  if (cSelectIndex != -1) {
    hideAddC(); updateItems(containers[cSelectIndex].id);
  } else {
    containerList.scrollTop = cListScroll;
    containerList.blur();
    hideAddI(); resetItems();
  }
});

cStatus.addEventListener("mouseover", () => {
  cStatMouse = true; cListMouse = false;
});

cStatus.addEventListener("scroll", () => {
  cStatScroll = cStatus.scrollTop;
  if (cStatMouse) {
    containerList.scrollTop = cStatScroll;
  }
});

userStatus == "ADMIN" ?
  cStatus.addEventListener("click", () => {
    let i = cStatElements.selectedIndex;
    let b = !cChecks[i]; editContainer([i, b]);
    cStatElements[i] = sOption(b);
    cStatus.scrollTop = cStatScroll;
    cStatus.blur();
  }) : -1;

itemList.addEventListener("mouseover", () => {
  iListMouse = true; iStatMouse = false;
});

itemList.addEventListener("scroll", () => {
  iListScroll = itemList.scrollTop;
  if (iListMouse) {
    iStatus.scrollTop = iListScroll;
  }
});

itemList.addEventListener("click", () => {
  let i = iElements.selectedIndex;
  iSelectIndex = iSelectIndex != i ? i : -1;
  iElements.selectedIndex = iSelectIndex;
  if (iSelectIndex != -1) {
    hideAddI();
  } else {
    itemList.scrollTop = iListScroll;
    itemList.blur();
  }
});

iStatus.addEventListener("mouseover", () => {
  iStatMouse = true; iListMouse = false;
});

iStatus.addEventListener("scroll", () => {
  iStatScroll = iStatus.scrollTop;
  if (iStatMouse) {
    itemList.scrollTop = iStatScroll;
  }
});

userStatus == "ADMIN" ?
  iStatus.addEventListener("click", () => {
    let i = iStatElements.selectedIndex;
    let b = !iChecks[i]; editItem([i, b]);
    iStatElements[i] = sOption(b);
    iStatus.scrollTop = iStatScroll;
    iStatus.blur();
  }) : -1;
