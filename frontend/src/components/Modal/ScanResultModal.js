import './ScanResultModal.css'

const ScanResultModal = ({ isOpen, onClose, data }) => {
  
  if (!isOpen) return null;

  const formatDate = (rawTimeStamp) => {
    if (!rawTimeStamp)
      return null;

    const date = new Date(rawTimeStamp * 1000);
    return date.toLocaleString();
  }

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className={"modal-content " + data["verdict"].toLowerCase()} onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <h2>Scan Report</h2>
          <button className="close-btn" onClick={onClose}>X</button>
        </div>
        <div className="modal-body data-display">
          <ul>
            <li><strong>Scan ID:</strong> {data.id}</li>
            <li><strong>Scan Type:</strong> {data.scanType}</li>
            <li><strong>Common File Name:</strong> {data.name}</li>
            <li><strong>SHA256 Hash:</strong> {data.sha256}</li>
            <li><strong>Total Engines:</strong> {data.totalEngines}</li>
            <li><strong>Threat Count:</strong> {data.threatCount}</li>
            <li><strong>Last Analysis Date:</strong> {formatDate(data.lastAnalysisDate)}</li>
            <li><strong>Verdict:</strong> {data.verdict}</li>
          </ul>
        </div>
        <div className="modal-footer">
          <p className={data["verdict"].toLowerCase()}>{data.verdict}</p>
        </div>
      </div>
    </div>
  );

};

export default ScanResultModal;