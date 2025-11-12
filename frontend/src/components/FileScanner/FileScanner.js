import './FileScanner.css'

import { useState } from 'react';
import { fetchScanFile } from '../../api/api';
import ScanResultModal from '../Modal/ScanResultModal';

const FileScanner = () => {
  const [file, setFile] = useState(null);
  
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [modalData, setModalData] = useState(false);

  const handleFileChange = (event) => {
    const selectedFile = event.target.files[0];
    if (selectedFile) {
      setFile(selectedFile);
    }
  };

  //Generated using AI, timeconstraint + didnt feel like using external library :>
  const getFileHash = async () => {
    const fileArrayBuffer = await file.arrayBuffer();  // Read the file as an ArrayBuffer
    const hashBuffer = await crypto.subtle.digest('SHA-256', fileArrayBuffer);  // Compute the hash
    const hashArray = Array.from(new Uint8Array(hashBuffer));  // Convert buffer to byte array
    const hashHex = hashArray.map(byte => byte.toString(16).padStart(2, '0')).join('');  // Convert byte array to hex string
    
    return hashHex;
  };

  const handleFileScan = () => {
    getFileHash().then((result) => {
        fetchScanFile(result).then((response) => {
          setModalData(response)
          setIsModalOpen(true)
        })
    })
  };

  const handleDiscard = () => {
    setFile(null);
  };

  const handleCloseModal = () => setIsModalOpen(false);

  return (
    <div className='file-scanner'>
      <input
        type="file"
        id="fileInput"
        style={{ display: 'none' }}
        onChange={handleFileChange}
      />
      <button onClick={() => document.getElementById('fileInput').click()}>
        Select File
      </button>
      <p>Selected File: {file ? file.name : "n/A"}</p>

      <div className='end-buttons'>
          <button disabled={!file} onClick={handleFileScan}>Scan File</button>
          <button disabled={!file} onClick={handleDiscard}>Discard File</button>
      </div>

      <ScanResultModal
        isOpen={isModalOpen}
        onClose={handleCloseModal}
        data={modalData}
      />
    </div>
  );
}

export default FileScanner
