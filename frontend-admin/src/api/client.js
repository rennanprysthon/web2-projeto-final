export async function client(url = '', options = {}) {

  return new Promise(async (resolve, reject) => {
    try {

      const response = await fetch(url, options);

      let json = {};
      try { 
        json = await response.json();
      } catch(errorJson) {
        console.log(errorJson)
      }

      resolve(json);
    } catch (error) {
      console.log(error)
      reject(error)
    }
  })
}