
const cURL = "http://Storageoftheallianceaws-env.eba-supwcfdm.us-east-1.elasticbeanstalk.com/containers";
const iURL = "http://Storageoftheallianceaws-env.eba-supwcfdm.us-east-1.elasticbeanstalk.com/items"

const containerList = document.getElementById("containers");
const cElements = containerList.options; const containers = [];
var cListMouse = null; var cListScroll = 0; var cSelectIndex = -1;

const cStatus = document.getElementById("container_status");
const cStatElements = cStatus.options; const cChecks = [];
var cStatMouse = null; var cStatScroll = 0;

const itemList = document.getElementById("items");
const iElements = itemList.options; const items = [];
var iListMouse = null; var iListScroll = 0; var iSelectIndex = -1;

const iStatus = document.getElementById("item_status");
var iStatElements = iStatus.options; const iChecks = [];
var iStatMouse = null; var iStatScroll = 0;

const buttons = document.getElementById("buttons");

const findItemElement = document.getElementById("find_item");
const iToFindName = document.getElementById("find_item_name");

const addContainerElement = document.getElementById("add_container");
const cToAddName = document.getElementById("add_container_name");

const addItemsElement = document.getElementById("add_items");
const iToAddNames = (() => { return ["0", "1", "2", "3", "4", "5"]
  .map(s => document.getElementById(s)); })();

const feedback = document.getElementById("feedback");
const results = document.getElementById("results");
const tab1 = "\xa0\xa0\xa0\xa0"; const tab2 = tab1 + tab1;

var userStatus = null;
