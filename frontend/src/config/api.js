export const API_CONFIG = {
  headers: {
    "Content-Type": "application/json",
  },
};

export const API_GET_ENDPOINTS = {
  scanFile: (sha256) => {
    return `/scan/file?sha256=${sha256}`;
  },
};