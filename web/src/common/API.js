const BASE_URI = "http://localhost:8080";

export const LOGIN = BASE_URI + "/login";
export const LIST_CREATE = BASE_URI + "/list/create";
export const LIST_SELECT = BASE_URI + "/list/select";
export const LIST_DELETE = BASE_URI + "/list/delete";
export const TODO_CREATE = BASE_URI + "/todo/create";
export const TODO_SELECT = BASE_URI + "/todo/select";
export const TODO_UPDATE = BASE_URI + "/todo/update";
export const TODO_DELETE = BASE_URI + "/todo/delete";

/**
 * POSTメソッド同期リクエスト
 * @param {string} url
 * @param {object} data
 */
export async function postData(url = "", data = {}) {
  const response = await fetch(url, {
    method: "POST",
    mode: "cors",
    cache: "no-cache",
    headers: {
      "Content-Type": "application/json",
    },
    referrerPolicy: "no-referrer",
    body: JSON.stringify(data),
  });
  return response.json();
}
