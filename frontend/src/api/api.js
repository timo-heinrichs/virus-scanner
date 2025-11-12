import { API_CONFIG, API_GET_ENDPOINTS } from "../config/api";
 
export const fetchScanFile = async (sha256) => {
    const response = await fetch(API_GET_ENDPOINTS.scanFile(sha256), {
        method: "GET",
        headers: API_CONFIG.headers
    });

    if (!response.ok) {
        throw new Error('Failed to scan file');
    }

    console.log(await response)

    const data = await response.json();
    
    return data
};