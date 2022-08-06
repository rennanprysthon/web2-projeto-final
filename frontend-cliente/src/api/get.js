import { client } from "./client";

export async function get(url) {
  return client(url, {
    method: 'GET'
  })
}