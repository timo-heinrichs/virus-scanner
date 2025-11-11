# 🧬 Virus Scanner – Full Stack Application

A full-stack **virus scanning web application** that integrates the **[VirusTotal API](https://docs.virustotal.com/reference/overview)** to offer a variety of options for scanning viruses.  
Built with a **React** frontend and a **Spring Boot (Java)** backend, this apps purpose is to act as a part of a portfolio.

*This piece of software is not meant to be used in a professional capacity

---

## 🧱 Architecture Overview

```bash
virus-scanner/
├── frontend/        # React + Vite (client-side interface)
└── backend/         # Spring Boot (REST API + VirusTotal API integration - basically just a wrapper of the VirusTotal API lol)