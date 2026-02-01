async function sendMessage() {
  const input = document.getElementById("user-input");
  const chatBox = document.getElementById("chat-box");

  const message = input.value;
  if (!message) return;

  // Show user message
  chatBox.innerHTML += `<div class="user">${message}</div>`;
  input.value = "";

  try {
    const response = await fetch("/chat", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ message })
    });

    const data = await response.json();

    // ✅ Correct key from backend
    chatBox.innerHTML += `<div class="bot">${data.reply}</div>`;

    chatBox.scrollTop = chatBox.scrollHeight;

  } catch (err) {
    console.error("Error:", err);
    chatBox.innerHTML += `<div class="bot">Oops! Something went wrong.</div>`;
  }
}
