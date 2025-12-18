<template>
  <div class="contact">
    <h1>Get In Touch</h1>
    <div class="contact-container">
      <div class="contact-info">
        <h2>Let's Connect</h2>
        <p>I'm always interested in hearing about new opportunities and exciting projects. Feel free to reach out!</p>
        
        <div class="contact-methods">
          <div class="contact-method">
            <strong>Email:</strong>
            <a href="mailto:john.doe@example.com">john.doe@example.com</a>
          </div>
          <div class="contact-method">
            <strong>LinkedIn:</strong>
            <a href="https://linkedin.com/in/johndoe" target="_blank">linkedin.com/in/johndoe</a>
          </div>
          <div class="contact-method">
            <strong>GitHub:</strong>
            <a href="https://github.com/johndoe" target="_blank">github.com/johndoe</a>
          </div>
        </div>
      </div>
      
      <div class="contact-form">
        <form @submit.prevent="handleSubmit">
          <div class="form-group">
            <label for="name">Name</label>
            <input type="text" id="name" v-model="form.name" required>
          </div>
          
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" v-model="form.email" required>
          </div>
          
          <div class="form-group">
            <label for="subject">Subject</label>
            <input type="text" id="subject" v-model="form.subject" required>
          </div>
          
          <div class="form-group">
            <label for="message">Message</label>
            <textarea id="message" v-model="form.message" rows="5" required></textarea>
          </div>
          
          <button type="submit" class="submit-btn" :disabled="isSubmitting">
            {{ isSubmitting ? 'Sending...' : 'Send Message' }}
          </button>
        </form>
        
        <div v-if="submitMessage" class="submit-message" :class="submitMessageType">
          {{ submitMessage }}
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const form = ref({
  name: '',
  email: '',
  subject: '',
  message: ''
})

const isSubmitting = ref(false)
const submitMessage = ref('')
const submitMessageType = ref('success')

const handleSubmit = async () => {
  isSubmitting.value = true
  submitMessage.value = ''
  
  try {
    // Simulate form submission
    await new Promise(resolve => setTimeout(resolve, 1000))
    
    submitMessage.value = 'Thank you for your message! I\'ll get back to you soon.'
    submitMessageType.value = 'success'
    
    // Reset form
    form.value = {
      name: '',
      email: '',
      subject: '',
      message: ''
    }
  } catch (error) {
    submitMessage.value = 'Oops! Something went wrong. Please try again.'
    submitMessageType.value = 'error'
  } finally {
    isSubmitting.value = false
  }
}
</script>

<style scoped>
.contact {
  max-width: 1000px;
  margin: 0 auto;
  padding: 2rem;
}

.contact h1 {
  text-align: center;
  margin-bottom: 3rem;
  color: #2c3e50;
}

.contact-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 3rem;
}

.contact-info h2 {
  color: #3498db;
  margin-bottom: 1rem;
}

.contact-info p {
  color: #555;
  line-height: 1.6;
  margin-bottom: 2rem;
}

.contact-methods {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.contact-method {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.contact-method strong {
  color: #2c3e50;
  min-width: 80px;
}

.contact-method a {
  color: #3498db;
  text-decoration: none;
}

.contact-method a:hover {
  text-decoration: underline;
}

.contact-form {
  background: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.form-group {
  margin-bottom: 1.5rem;
}

.form-group label {
  display: block;
  margin-bottom: 0.5rem;
  color: #2c3e50;
  font-weight: bold;
}

.form-group input,
.form-group textarea {
  width: 100%;
  padding: 0.75rem;
  border: 2px solid #ecf0f1;
  border-radius: 4px;
  font-size: 1rem;
  transition: border-color 0.3s ease;
}

.form-group input:focus,
.form-group textarea:focus {
  outline: none;
  border-color: #3498db;
}

.submit-btn {
  background: #3498db;
  color: white;
  border: none;
  padding: 0.75rem 2rem;
  border-radius: 4px;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.submit-btn:hover:not(:disabled) {
  background: #2980b9;
}

.submit-btn:disabled {
  background: #95a5a6;
  cursor: not-allowed;
}

.submit-message {
  margin-top: 1rem;
  padding: 0.75rem;
  border-radius: 4px;
  font-weight: bold;
}

.submit-message.success {
  background: #d4edda;
  color: #155724;
  border: 1px solid #c3e6cb;
}

.submit-message.error {
  background: #f8d7da;
  color: #721c24;
  border: 1px solid #f5c6cb;
}

@media (max-width: 768px) {
  .contact-container {
    grid-template-columns: 1fr;
    gap: 2rem;
  }
}
</style>