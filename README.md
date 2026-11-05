# Mobile App Development 1 - Assignment 1 (HelloToast Enhancements)

**Course:** Mobile App Development 1 (ITNM3315)  
**Instructor:** Eng. Ibrahim O. I. Kaware  
**Student Name:** Deema Al-Maqadma  
**Institution:** Al-Aqsa University  
**Repository:** `MOB1-Ass1-Deema_AL-Maqadma`

---

## 📌 Project Overview
This repository contains the complete implementation of **Assignment 1**, enhancing the standard **HelloToast** application to strictly match the expected visual and functional specifications. It features responsive **ConstraintLayout** mechanics, customized Action Bar theming, dynamic button parity styling, and support for both portrait and landscape screen orientations.

---

## 🚀 Key Implementations

### 1. Visual Hierarchy & Pixel-Perfect Dimensions
- **Action Bar Restored:** Customized `Theme.MaterialComponents.DayNight.DarkActionBar` displaying the title `Hello Constraint` in white on a `#3F51B5` primary background.
- **Portrait Bounds:** Constrained the count canvas (`text_display_count`) to 55% of the viewport height with vertical bias `0.0`, ensuring proper white spacing below the control cluster.
- **Button Chaining:** Buttons (`TOAST`, `ZERO`, `COUNT`) are vertically chained and evenly distributed between the top and bottom bounds of the count display.
- **Landscape Variant:** Dedicated `layout-land/activity_main.xml` utilizing horizontal distribution.

### 2. State-Driven Behavior
- **Zero Button Lifecycle:** Starts disabled in a neutral gray state (`#A0A0A0`). Automatically transitions to an active pink/magenta state (`#E91E63`) upon count increments.
- **Count Button Parity:** Dynamically alternates tinting between green (`#00E676`) for odd values and blue (`#3F51B5`) for even values.
- **Reset Logic:** Clicking `ZERO` resets the value to `0`, restores the inactive gray button tint, and resets the Count button to default.

---

## 📹 Video Demonstrations

* **YouTube Video Link (Demo):**  
  👉 [Watch the Full App Demonstration on YouTube](https://www.youtube.com) *(الصقي رابط اليوتيوب هنا بعد رفع الفيديو)*

* **Google Drive Link (Official Course Requirement):**  
  📁 [Access the Video on Google Drive](https://drive.google.com) *(الصقي رابط Google Drive هنا بعد الرفع)*

---

## 🛠️ Environment & Tools
- **IDE:** Android Studio
- **Programming Language:** Java (Native Android SDK)
- **Target Device:** Xiaomi Redmi Note 12 (Android 15)
- **Architecture:** Declarative XML + View Binding
