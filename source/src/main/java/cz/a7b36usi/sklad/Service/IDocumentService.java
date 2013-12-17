/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.DTO.MovementDTO;
import java.util.List;

/**
 *
 * @author Peter
 */
public interface IDocumentService {

    /**
     * Saves document into database
     *
     * @param document document to save
     * @return
     */
    public Long saveDocument(DocumentDTO document);

    /**
     * Saves movement into database
     *
     * @param movement movement to save
     * @return
     */
    public Long saveMovement(MovementDTO movement);

    /**
     * Removes document from database
     *
     * @param documentId identifier of document to be removed
     */
    public void removeDocument(Long documentId);

    /**
     * Removes movement from database
     *
     * @param movementId identifier of movement to be removed
     */
    public void removeMovement(Long movementId);

    /**
     * Retutns all documents from database
     *
     * @return all documents from database
     */
    public List<DocumentDTO> getAllDocuments();
    
    /**
     *
     * @param documentId    identifier of document to be retrieved
     * @return  documentDTO representing data from document with specified identifier
     */
    public DocumentDTO getDocumentById(Long documentId);

    /**
     * Retutns all movements from database
     *
     * @return all movements from database
     */
    public List<MovementDTO> getAllMovements();

    /**
     *
     * @param documentId identifier of document whose movements will be
     * retrieved
     * @return all movements associated with particular document
     */
    public List<MovementDTO> getAllDocumentsMovements(Long documentId);

    /**
     *
     * @param partnerId identifier of partner whose documents will be retrieved
     * @return all movements associated with particular document
     */
    public List<DocumentDTO> getAllPartnersDocuments(Long partnerId);

    /**
     *
     * @param productId identifier of product whose movements will be retrieved
     * @return all movements of particular product
     */
    public List<MovementDTO> getAllProductsMovements(Long productId);
}
